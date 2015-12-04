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

EXPOSE 9000

#Testing
RUN java -version
RUN javac -version

VOLUME /root

CMD ["/root/bin/app"]
