<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/fenix-renderers.tld" prefix="fr" %>


<h2>
	<fr:view name="type" property="name"/>
</h2>

<ul>
	<li>
		<html:link page="/competencesManagement.do?method=manageCompetences">
			<bean:message key="link.back" bundle="MYORG_RESOURCES"/>
		</html:link>
	</li>
</ul>


<fr:view name="type" property="competences">
	<fr:schema type="module.siadap.domain.Competence" bundle="SIADAP_RESOURCES">
		<fr:slot name="number"/>
		<fr:slot name="name" key="label.competence.name"/>
		<fr:slot name="description"/>
	</fr:schema>
	<fr:layout name="tabular">
		<fr:property name="classes" value="tstyle2"/>
		<fr:property name="sortBy" value="number"/>
	</fr:layout>
</fr:view>