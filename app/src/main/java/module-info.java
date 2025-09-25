module responsive {

    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.swing;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.naming;

    requires jakarta.persistence;
    requires jakarta.xml.bind;
    requires jakarta.transaction;


    requires org.jboss.logging;
    requires com.fasterxml.classmate;
    requires net.bytebuddy;

    requires  org.postgresql.jdbc;
    requires transitive jenvy;
    requires atlantafx.base;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.boxicons;
    requires org.kordamp.ikonli.bytedance;
    requires org.kordamp.ikonli.fluentui;
    requires lombok;

    exports org.example;



    opens org.example to jakarta.persistence,org.hibernate.orm.core, net.bytebuddy;
    opens org.example.entity to jakarta.persistence,org.hibernate.orm.core,net.bytebuddy;
    opens org.example.pages to jenvy;
    opens org.example.models to jenvy;



}
