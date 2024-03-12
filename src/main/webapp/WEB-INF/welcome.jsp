<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>KSR</title>
</head>
<body>
<h1>Enroll the basic details of Train</h1>

 <pre>
  <form action="readValues">

    
    <label>Train name</label>
   <input type = "text" name = "trainName">
   <p  style="color: red">${errorTrainName}</p>
  
   <label>Train speed</label>
   <input type = "text" name = "trainSpeed">
   <p  style="color: red">${errorTrainSpeed}</p>
   
   <label>Train colour</label>
   <input type = "text" name = "trainColor">
   <p  style="color: red">${errorTrainColor}</p>
   
   <label>Number of compartments</label>
   <input type = "text" name = "noOfCompartments">
    <p  style="color: red">${errorInCompart}</p>
   
   <label>Number of wheels</label>
   <input type = "text" name = "noOfWheels">
    <p  style="color: red">${errorInNumber}</p>
   
   <label>train type</label>
   <input type = "text" name = "trainType">
   <p  style="color: red">${errorInTrainType}</p>
   
  <input type = "submit" value = "submit">    
 
 </form>
 </pre>
 
  
    <h1>Update Train Details</h1>
    
   <form action="updateTrainEntity">
  <p style = "color :red">${ErrorTrainName}</p>
   
   
   <label>Train Name</label>
   <input type = "text" name = "trainName" placeholder = "Enter TrainName" value ="${TrainName}">
   <p  style="color: red">${errorTrainName}</p>
  
   <label>Train speed</label>
   <input type = "text" name = "trainSpeed" placeholder = "Enter TrainSpeed" value ="${TrainSpeed}">
   <p  style="color: red">${errorTrainSpeed}</p>
   
   <label>Train colour</label>
   <input type = "text" name = "trainColor" placeholder = "Enter TrainColor" value ="${TrainColor}">
   <p  style="color: red">${errorTrainColor}</p>
   
   <label>Number of compartments</label>
   <input type = "text" name = "noOfCompartments" placeholder = "Enter Number" value ="${NoOfCompartments}">
    <p  style="color: red">${errorInCompart}</p>
   
   <label>Number of wheels</label>
   <input type = "text" name = "noOfWheels" placeholder = "Enter Number" value ="${NoOfWheels}">
    <p  style="color: red">${errorInNumber}</p>
   
   <label>Train Type</label>
   <input type = "text" name = "trainType" placeholder = "Enter TrainType" value ="${TrainType}">
   <p  style="color: red">${errorInTrainType}</p>
   
   <input type = "submit" value = "Update"> 
 
 </form>
 
 
 <h1>Enter Train Name and get details</h1>
 
<form action="searchForTrainEntity">
   <label>TrainName</label>
   <input type = "text" name = "trainName" placeholder = "enter trainName">
   <p style = "color: red">${TrainNameNotFound}</p>
   
   <input type = "submit" value = "search" >
   
</form>

<ol>
   <li>${TrainName}</li>
   <li>${TrainSpeed}</li>
   <li>${TrainColor}</li>
   <li>${NoOfCompartments}</li>
   <li>${NoOfWheels}</li>
   <li>${TrainType}</li>

</ol> 

<a href = "getAllTrainInformation">getAllTrainInformation</a>

<table>
   <tr>
       <th> TrainName </th>
       <th> TrainSpeed </th>
       <th> TrainColor </th>
       <th> NoOfCompartments </th>
       <th> NoOfWheels </th>
       <th> TrainType </th>  
   </tr>
   
   <c:forEach items ="${getAllTrains}" var ="a"> 
   
   <tr>
   <td>${a.trainName}</td>
   <td>${a.trainSpeed}</td>
   <td>${a.trainColor}</td>
   <td>${a.noOfCompartments}</td>
   <td>${a.noOfWheels}</td>
   <td>${a.trainType}</td> 
   </tr>  
   
   </c:forEach>
  
</table>

   
     <h1>Delete The Train</h1>
     
	    <form action="deleteTrainName">
		<label><b>TrainName</b></label>
		<p style = "color: red">${Deleted}</p>
		<input type="text" name="trainName" placeholder="Enter Name"> 
		<input type="submit" value="delete">
			
</form>
</body>
</html>