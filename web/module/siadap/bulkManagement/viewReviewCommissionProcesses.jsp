<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/fenix-renderers.tld" prefix="fr"%>

<bean:define id="unitId" name="unit" property="unit.externalId" />

<bean:define id="year" name="unit" property="year"/>

<h2><fr:view name="unit" property="name" /></h2>

<p><fr:view name="employees">
	<fr:schema type="module.siadap.domain.wrappers.PersonSiadapWrapper" bundle="SIADAP_RESOURCES">
		<fr:slot name="person.partyName" layout="format" key="label.evaluated">
			<fr:property name="useParent" value="true" />
			<fr:property name="format" value="${person.partyName} (${person.user.username})"/>
		</fr:slot>
		<fr:slot name="siadap.state.description" key="label.process.state"/>
		<fr:slot name="finalClassificationForSIADAP2" layout="null-as-label" key="label.validation.classification.SIADAP2"/>
		<fr:slot name="siadap.siadap2EvaluationAfterValidation" layout="null-as-label" key="label.validation.evaluation.SIADAP2"/>
		<fr:slot name="finalClassificationForSIADAP3" layout="null-as-label" key="label.validation.classification.SIADAP3"/>
		<fr:slot name="siadap.siadap3EvaluationAfterValidation" layout="null-as-label" key="label.validation.evaluation.SIADAP3"/>
	</fr:schema>
	<fr:layout name="tabular-sortable">
		<fr:property name="classes" value="tstyle2" />
		<fr:property name="link(viewProcess)" value="/workflowProcessManagement.do?method=viewProcess" />
		<fr:property name="bundle(viewProcess)" value="MYORG_RESOURCES" />
		<fr:property name="key(viewProcess)" value="link.view" />
		<fr:property name="param(viewProcess)" value="siadap.process.externalId/processId" />
		<fr:property name="order(viewProcess)" value="1" />
		<fr:property name="visibleIf(viewProcess)" value="accessibleToCurrentUser" />

		<fr:property name="sortParameter" value="sortBy" />
		<fr:property name="sortUrl"
			value="<%="/siadapManagement.do?method=viewReviewCommissionProcesses&unitId=" + unitId + "&year=" + year.toString()%>" />
		<fr:property name="sortBy"
			value="<%=request.getParameter("sortBy") == null ? "person.partyName=asc" : request
			    .getParameter("sortBy")%>" />
	</fr:layout>
</fr:view></p>
<jsp:include page="/module/siadap/tracFeedBackSnip.jsp">	
   <jsp:param name="href" value="https://fenix-ashes.ist.utl.pt/trac/siadap/report/18" />	
</jsp:include>