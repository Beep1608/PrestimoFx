module responsive {
   requires javafx.controls;
   requires javafx.graphics;
   requires javafx.swing;
   requires java.sql;
  requires   org.hibernate.orm.core;
  requires java.naming;

  requires jakarta.persistence;
  requires jakarta.xml.bind;
  requires jakarta.transaction;


  requires org.jboss.logging;
  requires com.fasterxml.classmate;
  requires net.bytebuddy;

  requires  org.postgresql.jdbc;

  exports org.example;



  opens org.example to jakarta.persistence,  org.hibernate.orm.core;
  opens org.example.jewelry to jakarta.persistence, org.hibernate.orm.core;
  opens  org.example.buy_jewelry to jakarta.persistence, org.hibernate.orm.core,javafx.base;
  opens  org.example.buy_caratages_percentages to jakarta.persistence, org.hibernate.orm.core;
  opens org.example.buy_percentages to jakarta.persistence, org.hibernate.orm.core;
  opens  org.example.metal_prices to jakarta.persistence, org.hibernate.orm.core;
  opens org.example.currency_prices to jakarta.persistence, org.hibernate.orm.core;
  opens org.example.constants to jakarta.persistence, org.hibernate.orm.core;
  opens  org.example.buy_jewelry.dto to jakarta.persistence, org.hibernate.orm.core,javafx.base;

 
}
