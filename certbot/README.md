
Initial run :

    sudo certbot  -c certbox.conf certonly -d foggly-backup.ftp.sh


Renew :

    sudo certbot -c certbox.conf renew


Fix permissions for non-root usage:


    chmod -R 755 archive/
    chmod -R 755 live/

