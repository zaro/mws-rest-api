#!/bin/bash

set -e

gradle clean && gradle installDist

[ $? != 0 ] &&  exit


cat build/install/mws-rest-api/cfg/config.json | sed 's/8181/3000/' > build/install/mws-rest-api/cfg/config.json.edit
mv build/install/mws-rest-api/cfg/config.json.edit build/install/mws-rest-api/cfg/config.json

echo 'web: /srv/home/www/bin/mws-rest-api' > build/install/mws-rest-api/Procfile

scp -r build/install/mws-rest-api/* mws-proxy.amasel.co:www/
#rsync -P build/install/mws-rest-api/ mws-proxy.amasel.co:www/

ssh mws-proxy.amasel.co 'cd /srv/home/www ; /usr/local/deploy_hook'
