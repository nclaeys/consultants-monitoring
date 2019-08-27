FROM java:8

RUN mkdir -p opt

ADD pmt-0.0.1-SNAPSHOT.jar /opt/axxes-pmt.jar

WORKDIR /opt

RUN chmod +x axxes-pmt.jar

CMD ["java","-jar","axxes-pmt.jar"]

EXPOSE 8080