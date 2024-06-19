package com.odontograma.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odontograma.form.PiezaDentariaForm;
import com.odontograma.utils.OldDBConnection;

public class AddPiezaDentariaAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PiezaDentariaForm piezaDentariaForm = (PiezaDentariaForm) form;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            // TODO: Assess constraints before saving

            connection = OldDBConnection.getConnection();     
            String sql = "INSERT INTO PIEZAS_DENTARIAS (NRO_PIEZA, DETALLE, TIPO_DENTICION, GRUPO_DENTARIO, SUBGRUPO, ARCADA, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, piezaDentariaForm.getNroPieza());
            preparedStatement.setString(2, piezaDentariaForm.getDescripcion());
            preparedStatement.setString(3, piezaDentariaForm.getTipoDenticion());
            preparedStatement.setString(4, piezaDentariaForm.getGrupoDentario());
            preparedStatement.setString(5, piezaDentariaForm.getSubgrupo());
            preparedStatement.setString(6, piezaDentariaForm.getArcada());
            preparedStatement.setBoolean(7, piezaDentariaForm.getEstado());

            preparedStatement.executeUpdate();

            return mapping.findForward("success");
        } catch (Exception e) {
            e.printStackTrace();
            return mapping.findForward("failure");
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}