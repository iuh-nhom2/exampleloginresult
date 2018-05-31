<?php
	require "connect.php";
	$username = $_POST['username'];
	$password = $_POST['password'];
	$mypassword = md5($password);
	$image = $_POST['image'];

	// $username ="phung13197";
	// $password = "123";
	
	// $image = "asdas";
	// $mypassword = md5($password);
	if(strlen($username) >0 && strlen($password) && strlen($image)>0){
		$sql = "INSERT INTO user VALUES (null,'$username','$mypassword','$image')";
		$result= mysqli_query($connect,$sql);
		
		if($result){
			echo "Success";
		}else{
			echo "Failed";
		}
	}else{
			echo "null";
		}


?>