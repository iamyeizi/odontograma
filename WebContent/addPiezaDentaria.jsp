<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Pieza Dentaria</title>
</head>
<body>
    <h1>Agregar Pieza Dentaria</h1>
    <html:form action="/addPiezaDentaria.do">
        <table>
            <tr>
                <td>Número de Pieza:</td>
                <td><html:text property="nroPieza"/></td>
            </tr>
            <tr>
                <td>Descripción:</td>
                <td><html:text property="descripcion"/></td>
            </tr>
            <tr>
                <td>Tipo de Dentición:</td>
                <td>
                    <html:select property="tipoDenticion">
                        <html:option value="Primaria">Primaria</html:option>
                        <html:option value="Secundaria">Secundaria</html:option>
                    </html:select>
                </td>
            </tr>
            <tr>
                <td>Grupo Dentario:</td>
                <td>
                    <html:select property="grupoDentario">
                        <html:option value="Anterior">Anterior</html:option>
                        <html:option value="Posterior">Posterior</html:option>
                    </html:select>
                </td>
            </tr>
            <tr>
                <td>Subgrupo:</td>
                <td>
                    <html:select property="subgrupo">
                        <html:option value="Incisivos">Incisivos</html:option>
                        <html:option value="Caninos">Caninos</html:option>
                        <html:option value="Premolares">Premolares</html:option>
                        <html:option value="Molares">Molares</html:option>
                    </html:select>
                </td>
            </tr>
            <tr>
                <td>Arcada:</td>
                <td>
                    <html:select property="arcada">
                        <html:option value="Superior Derecha">Superior Derecha</html:option>
                        <html:option value="Superior Izquierda">Superior Izquierda</html:option>
                        <html:option value="Inferior Derecha">Inferior Derecha</html:option>
                        <html:option value="Inferior Izquierda">Inferior Izquierda</html:option>
                    </html:select>
                </td>
            </tr>
            <tr>
                <td>Estado:</td>
                <td>
                    <html:select property="estado">
                        <html:option value="true">Activa</html:option>
                        <html:option value="false">Extraida</html:option>
                    </html:select>
                </td>
            </tr>
            <tr>
                <td colspan="2"><html:submit value="Agregar"/></td>
            </tr>
        </table>
    </html:form>
</body>
</html>
