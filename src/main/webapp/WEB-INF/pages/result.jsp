<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:choose>
	<c:when test="${!empty(placeList)}">
		<table>
			<tbody>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Full Name</th>
					<th>Iata Airport Code</th>
					<th>Type</th>
					<th>Country</th>
					<th>In Europe</th>
					<th>Country Code</th>
					<th>Latitude</th>
					<th>Longitude</th>
				</tr>
				<c:forEach items="${placeList}" var="place">
					<tr>
						<td><c:out value="${place._id}"></c:out></td>
						<td><c:out value="${place.name}"></c:out></td>
						<td><c:out value="${place.fullName}"></c:out></td>
						<td><c:out value="${place.iata_airport_code}"></c:out></td>
						<td><c:out value="${place.type}"></c:out></td>
						<td><c:out value="${place.country}"></c:out></td>
						<td><c:out value="${place.inEurope}"></c:out></td>
						<td><c:out value="${place.countryCode}"></c:out></td>
						<td><c:out value="${place.geo_position.latitude}"></c:out></td>
						<td><c:out value="${place.geo_position.longitude}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
		<input type="button" value="Download CSV" onclick="location.href='<c:url value="/csv/${text}'"/>">
		
		
	</c:when>
	<c:otherwise>
         <p class="noresult">No results found.</p>     
    </c:otherwise>
</c:choose>

