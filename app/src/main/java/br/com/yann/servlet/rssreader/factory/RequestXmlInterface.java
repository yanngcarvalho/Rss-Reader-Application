package br.com.yann.servlet.rssreader.factory;

import java.io.IOException;

import jakarta.xml.bind.JAXBException;

public interface RequestXmlInterface{

  public String getXml (String uri) throws IOException, JAXBException;

}

