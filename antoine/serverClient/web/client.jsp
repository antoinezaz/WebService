<%@ page import="java.net.URL" %>
<%@ page import="javax.xml.namespace.QName" %>
<%@ page import="javax.xml.ws.Service" %>
<%@ page import="ville.VilleSOAP" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    URL wsdlURL = new URL("http://localhost:8080/services/VilleImplSOAP?wsdl");
    //creating QName using targetNamespace and name
    QName qname = new QName("http://ville/", "VilleImplService");

    Service service = Service.create(wsdlURL, qname);

    //We need to pass interface and model beans to client
    VilleSOAP hw = service.getPort(VilleSOAP.class);

    out.println(hw.getCodePostal("Villemoisson"));
    out.println(hw.getVille(75000));
    HashMap<Integer, String> map = new Gson().fromJson(hw.getVilles(), HashMap.class);
    out.println(map);

%>
</body>
</html>
