<%-- 
    Document   : home
    Created on : Jun 4, 2022, 9:14:12 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HomePage</title>
    </head>
    <body>
        <h1>Home Page</h1>
    <c:forEach var="dt" items="${articles}" >
        <div>
            <div><c:out value="${dt.articleContent}"/> </div>
            <div style="width: 200px"><img src="images/${dt.imgUrl}" width="100%"></div>
            <div><c:out value="${dt.item.itemName}"/></div>
            <div><c:out value="${dt.type.typeName}"/></div>
            <a href="UpdateFormServlet?aId=${dt.articleID}">Update</a>
            <a href="DeleteServlet?aId=${dt.articleID}" onclick="return confirm('Are you sure?')">REMOVE</a>  
            <a href="index.jsp">Profile</a>
        </div>
        <br/>
            </c:forEach>
    </body>
</html> --%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- Bootstrap CSS -->
    <script src="https://kit.fontawesome.com/f2fda88f12.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="node_modules/bootstrap/dist/css/bootstrap.min.css" />

    <link rel="stylesheet" href="node_modules/bootstrap-social/bootstrap-social.css" />
    <link rel="stylesheet" href="css/style.css" />
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
    <header>
        <nav class="navbar navbar-dark fixed-top">
            <div class="navbar">
                <button class="rounded-circle" type="button" data-toggle="collapse" data-target="#Navbar">
                    <img class="rounded-circle" src="${userdata.picture}" height="30" width="100%">
                </button>
                <span class="Nav-username" style="width: 300px;"><c:out value="${userdata.memberName}"/></span>
            </div>
            <div class="search col-md-4">
                <div class="search-field">
                    <div class="search-icon"></div>
                    <input type="text" class="search-input" placeholder="Search">
                </div>

                <div class="dropdown">
                    <div class="dropdown-select">
                        <span class="dropdown-value">Search by</span>
                        <span>
                            <svg xmlns="http://www.w3.org/2000/svg" style="width: 20px; height: 10px" fill="none"
                                viewBox="0 0 24 24" stroke="currentColor">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                    d="M19 9l-7 7-7-7" />
                            </svg>
                        </span>
                    </div>
                    <div class="dropdown-list">
                        <div class="dropdown-item">Name</div>
                        <div class="dropdown-item">Categories</div>
                    </div>
                </div>
                <button class="search-button">Search</button>
            </div>

        </nav>
        <div class="collapse navbar-collapse" id="Navbar">
            <ul class="navbar-nav container ml-5">
                <li class="nav-item">
                    <a class="nav-link" href="ListPostServlet"><i class="fa fa-home fa-lg"></i>Home </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><span class="fa-solid fa-user"></span> Personal Page</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./"><span class="fa-regular fa-thumbs-up"></span>
                        Liked list</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="LogoutServlet"><i class="fa-solid fa-arrow-right-from-bracket"></i> Logout</a>
                </li>
            </ul>
        </div>

    </header>

    <div class="tabs">
        <div class="tab-item active">
            Cần Tìm
        </div>
        <div class="tab-item">
            Nhặt Được
        </div>
        <div class="tab-item">
            Chia Sẻ Kinh nghiệm
        </div>
        <div class="line"></div>
    </div>
    <!-- tab content -->
    <div class="tab-content ">
        <a type="button" href="CreateFormServlet" class="center createPost--btn btn rounded-circle">+</a>
        <div class="row tab-pane active">
            <c:forEach var="dt" items="${articlesFind}" >
            <div class="pane col-md-3">
                <div class="pane-img">
                    <img src="images/${dt.imgUrl}" alt="">
                </div>
                <div class="pane-content">
                    <p>Time: <c:out value="${dt.postTime}"/></p>
                    <p>Item type: <c:out value="${dt.item.itemName}"/></p>
                    <p>ArticleType: <c:out value="${dt.type.typeName}"/></p>
                    <a href="UpdateFormServlet?aId=${dt.articleID}">Update</a>
                    <font-awesome-icon icon="fa-solid fa-phone" />

                </div>
            </div>
            </c:forEach>
        </div>
        <div class="row tab-pane ">
            <c:forEach var="dt" items="${articlesReturn}" >
            <div class="pane col-md-3">
                <div class="pane-img">
                    <img src="images/${dt.imgUrl}" alt="">
                </div>
                <div class="pane-content">
                    <p>Time: <c:out value="${dt.postTime}"/></p>
                    <p>Item type: <c:out value="${dt.item.itemName}"/></p>
                    <p>ArticleType: <c:out value="${dt.type.typeName}"/></p>
                    <a href="UpdateFormServlet?aId=${dt.articleID}">Update</a>
                    <font-awesome-icon icon="fa-solid fa-phone" />

                </div>
            </div>
            </c:forEach>
            
            
        </div>
        <div class="row tab-pane ">
            <c:forEach var="dt" items="${articlesShare}" >
            <div class="pane col-md-3">
                <div class="pane-img">
                    <img src="images/${dt.imgUrl}" alt="">
                </div>
                <div class="pane-content">
                    <p>Time: <c:out value="${dt.postTime}"/></p>
                    <p>Item type: <c:out value="${dt.item.itemName}"/></p>
                    <p>ArticleType: <c:out value="${dt.type.typeName}"/></p>
                    <a href="UpdateFormServlet?aId=${dt.articleID}">Update</a>
                    <font-awesome-icon icon="fa-solid fa-phone" />

                </div>
            </div>
            </c:forEach>
            
        </div>

    </div>
    <footer>
        Footer
    </footer>
    <!-- modal -->
    <!-- <div id="postModal" class="modal fade" role="dialog">
        <div class="modal-dialog modal-lg" role="content">
           
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="font-strong text-white">Create post</h3>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <div id="postform" class=" col-sm-6 col-md-12 align-self-center">
                        <div class="">
                            <div class="card-body">
                                <dl class="">
                                    <div class="modal-post--user">
                                        <button class="rounded-circle" type="button" data-toggle="collapse"
                                            data-target="#Navbar">
                                            <img class="rounded-circle" src="img/logo.jpg" height="30" width="100%">
                                        </button>
                                        <span>User name</span>
                                    </div>
                                    <div class="modal-post--input">
                                        <input type="text" class="form-control form-control-lg form-control-plaintext">
                                        <input type="file" class="form-control-file border">
                                    </div>
                                </dl>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div> -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS. -->
    <script src="js/mycode.js"></script>
    <script src="node_modules/jquery/dist/jquery.slim.min.js"></script>
    <script src="node_modules/popper.js/dist/umd/popper.min.js"></script>
    <script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
</body>

</html>
