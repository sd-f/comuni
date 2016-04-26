@XmlSchema(
        namespace = "http://www.campusonline.at/xsd/comuni/v1",
        location = "http://www.campusonline.at/xsd/comuni/v1",
        elementFormDefault = XmlNsForm.UNQUALIFIED,
        attributeFormDefault = XmlNsForm.UNQUALIFIED,
        xmlns = {
                @XmlNs(namespaceURI = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi")
        })
package foundation.softwaredesign.comuni.lib.boundary;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;