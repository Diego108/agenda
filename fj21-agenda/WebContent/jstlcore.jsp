<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<body>

	<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao">

	<c:import url="cabecalho.jsp"></c:import>
		<table>
			<c:forEach var="contato" items="${dao.lista}" varStatus="id">
				
				<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
					<td>${contato.nome}</td>
					<td><c:if test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:if></td>
					<td>
						<c:choose>
							<c:when test="${empty contato.endereco}">
							endereço vazio
							</c:when>
							<c:otherwise>
							${contato.endereco}
							</c:otherwise>
						</c:choose>
					</td>
					
					<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yy"/></td>
				</tr>

			</c:forEach>
		</table>
		<c:import url="Rodape.jsp"></c:import>
	</jsp:useBean>
</body>
</html>