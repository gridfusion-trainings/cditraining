#!/bin/bash
file="/home/e34/Downloads/jobs.tar.gz"

if [ -f "$file" ]
then
	echo "Old $file found. Deleting it"
	rm -rf $file
fi

wget -P /home/e34/Downloads https://s3.amazonaws.com/e34/jobs.tar.gz
#wget -P /home/e34/Downloads http://192.168.1.103:80/jobs.tar.gz
sudo chmod 777 $file
echo "untar jobs.tar.gz into jenkins_home"
tar -xvf $file -C /home/e34/jenkins_home/





