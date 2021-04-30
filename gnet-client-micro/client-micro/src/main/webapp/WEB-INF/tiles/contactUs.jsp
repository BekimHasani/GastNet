<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="main-body flex">
		<div class="left-main-body">
			<div class="left-contact-content">
				<h2>We love to hear from you! Send us your questions, comments
					or ideas!</h2>
				<p>
					Customer Support: <strong>877-569-6118.</strong>
				</p>
				<br>
				<br>

				<form action="" method="post">
					<table id="contactus-input-table">
						<tr>
							<td><label for="">Your Name:</label></td>
							<td><input type="text" name="name" value="" required>
							</td>
						</tr>
						<tr>
							<td><label for="">Your Email:</label></td>
							<td><input type="email" name="email" value="" required>
							</td>
						</tr>
						<tr>
							<td><label for="">Subject :</label></td>
							<td><input type="text" name="subject" value="" required>
							</td>
						</tr>
					</table>
					<label for="">Message:</label><br>
					<textarea id="contactus-textarea" name="description" rows="8"
						cols="80" minlength="60" placeholder="Minimum 30 characters"></textarea>
					<br> <input type="submit" name="contactus" value="Contact Us" style="margin-left: 80%;">
				</form>
			</div>
		</div>
		<div class="right-main-body">
			<div class="right-contact-content"></div>
		</div>
	</div>
</body>
</html>