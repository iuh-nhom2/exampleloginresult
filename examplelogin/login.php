<?php
	require "connect.php";

	// $username = $_POST['username'];
	// $password = $_POST['password'];

	$username = "f";
	$password = "c";
	$mypassword = md5($password);
	
	class User{
		function User($id,$user,$pass,$hinh){
			$this->Id   = $id;
			$this->Taikhoan = $user;
			$this->Matkhau = $pass;
			$this->Hinh = $hinh;
		}
	}
	if(strlen($username) >0 && strlen($password) >0){
		$manguser =array();
		$sql= "SELECT *FROM user WHERE username ='$username' and password ='$mypassword'";
		
		$data= mysqli_query($connect,$sql);
		if($data){
			while($row = mysqli_fetch_assoc($data)){
				array_push($manguser, new User($row['id'],$row['username'],$row['password'],$row['hinh']));
			}
			if(count($manguser) >0){
				echo json_encode($manguser);
			}else{
				echo "Fail";
			}

		}
	}else{
			echo "Null";
		}
?>