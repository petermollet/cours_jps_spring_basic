<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
</head>
<body>
    <div align="center">
        <h2>Add a product</h2>
        <form:form action="add-product" method="post" modelAttribute="product">
            <form:label path="name">Name:</form:label>
            <form:input path="name"/><br/>
    
            <form:label path="price">Price:</form:label>
            <form:input type="number" path="price"/><br/>
    
            <form:button>Submit</form:button>
        </form:form>

    </div>
</body>
</html>