<%@ include file="./header.jspf" %>

<h3 class="text-danger">OOPS! There was an error while processing your request</h3>

<p>Please retry after a while , and if the error persists, please write to 
<a href="mailto:bratin4201@gmail.com">helpdesk@Bratin.com</a></p>

<button class="btn btn-link" onclick="showErrorDetails()">Show technical details</button>

<pre style="visibility: hidden" id="errDetails">
<%

Exception ex = (Exception)request.getAttribute("ex");
ex.printStackTrace(new java.io.PrintWriter(out));

%></pre>



<%@ include file="./footer.jspf" %>

<script>

function showErrorDetails(){
	document.getElementsById("errDetails").style.visibility="visible";
}

</script>