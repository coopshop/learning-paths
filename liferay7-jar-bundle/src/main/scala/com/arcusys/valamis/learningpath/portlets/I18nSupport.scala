package com.arcusys.valamis.learningpath.portlets

import java.io.{FileInputStream, InputStream, InputStreamReader}
import java.util.Properties
import javax.portlet.{GenericPortlet, PortletContext}

import scala.collection.JavaConversions._

trait I18nSupport {
  self: GenericPortlet =>

  val ResourcesPath = "META-INF/resources"

  def getResourceAsStream(portlet: GenericPortlet, path: String): InputStream = {
    val suffix = if(path.startsWith("/")) "" else "/"
    this.getClass.getClassLoader.getResourceAsStream("/" + ResourcesPath + suffix + path)
  }

  def getTranslation(path: String): Map[String, String] = {
    val properties = propertiesForPortlet(path, self.getPortletContext).toMap

    mapAsScalaMap(properties).toMap.map { case (k, v) => (k.toString, v.toString) }
  }

  private def propertiesForPortlet(templatePath: String, context: PortletContext) = {
    val properties = new Properties
    val resourceStream = getResourceAsStream(this, templatePath + ".properties")
    val reader = new InputStreamReader(resourceStream, "UTF-8")

    properties.load(reader)
    resourceStream.close()
    properties
  }
}