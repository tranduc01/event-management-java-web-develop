<!DOCTYPE html>
<html lang="en" class="h-100">
    <%@ page contentType="text/html; charset=UTF-8" %>

    

    <body class="h-100">
        <div class="authincation h-100">
            <div class="container h-100">
                <div class="row justify-content-center h-100 align-items-center">
                    <div class="col-md-6">
                        <div class="authincation-content">
                            <div class="row no-gutters">
                                <div class="col-xl-12">
                                    <div class="auth-form">
                                        <div class="text-center mb-3">
                                            <a href="index.html"><img src="#" alt=""></a>
                                        </div>
                                        <h4 class="text-center mb-4 text-white">Sign in your account</h4>
                                        <form action="MainController" method="POST">
                                            <div class="form-group">
                                                <label class="mb-1 text-white"><strong>User Name</strong></label>
                                                <input type="text" name="username" class="form-control" placeholder="User Name" value="">
                                            </div>
                                            <div class="form-group">
                                                <label class="mb-1 text-white"><strong>Password</strong></label>
                                                <input type="password" name="password" class="form-control" placeholder="Password" value="">
                                            </div>
                                            <div class="form-row d-flex justify-content-between mt-4 mb-2">
                                                <div class="form-group">
                                                    <div class="custom-control custom-checkbox ml-1 text-white">
                                                        <input type="checkbox" class="custom-control-input" id="basic_checkbox_1">
                                                        <label class="custom-control-label" for="basic_checkbox_1">Remember my preference</label>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <a class="text-white" href="page-forgot-password.html">Forgot Password?</a>
                                                </div>
                                            </div>
                                            <div class="text-center">
                                                <button type="submit" name="action" value="Login" class="btn bg-white text-primary btn-block">Sign Me In</button>
                                            </div>
                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!--**********************************
            Scripts
        ***********************************-->
        <!-- Required vendors -->
        <script src="./css_Admin/vendor/global/global.min.js"></script>
        <script src="./css_Admin/js/custom.min.js"></script>
        <script src="./css_Admin/js/deznav-init.js"></script>

    </body>

</html>
