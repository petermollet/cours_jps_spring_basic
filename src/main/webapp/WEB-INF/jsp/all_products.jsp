<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>All Products</title>
</head>
<body>
    <div align="center">
        <h2>All Products</h2>
        <table border="1" bgcolor="#FEF9E7">
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>PRICE (Euro)</th>
            </tr>

            <!-- PRODUCTS -->
            <c:forEach items="${products}"  var="p" >
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.price}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>

