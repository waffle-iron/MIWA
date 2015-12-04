#Use debian image
FROM debian:latest

MAINTAINER boisse_l <boisse_l@epita.fr>

USER root
# update and upgrade debian
RUN apt-get update && apt-get -y upgrade && apt-get -y autoremove

#Add Oracle repository
RUN echo "deb http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main" | tee /etc/apt/sources.list.d/webupd8team-java.list
RUN echo "deb-src http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main" | tee -a /etc/apt/sources.list.d/webupd8team-java.list
RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys EEA14886
RUN apt-get update
#Accept Oracle License
RUN echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 boolean true" | debconf-set-selections
# Install Oracle Java
RUN apt-get -y install oracle-java8-installer

#Install mysql
RUN echo "deb http://repo.mysql.com/apt/debian/ wheezy mysql-5.6" > /etc/apt/sources.list.d/mysql.list
RUN apt-key adv --keyserver ha.pool.sks-keyservers.net --recv-keys A4A9406876FCBD3C456770C88C718D3B5072E1F5
RUN { \
    echo mysql-community-server mysql-community-server/data-dir select ''; \
    echo mysql-community-server mysql-community-server/root-pass password 'root'; \
    echo mysql-community-server mysql-community-server/re-root-pass password 'root'; \
    echo mysql-community-server mysql-community-server/remove-test-db select false; \
} | debconf-set-selections
RUN apt-get update
RUN apt-get install -y mysql-server


EXPOSE 9000

#Testing
RUN java -version
RUN javac -version
RUN service --status-all

VOLUME /root

ENTRYPOINT ["/root/tpmiwa-1.0/bin/tpmiwa"]