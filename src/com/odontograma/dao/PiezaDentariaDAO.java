package com.odontograma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.odontograma.model.PiezaDentaria;
import com.odontograma.utils.DBConnection;

public class PiezaDentariaDAO implements BaseDAO<PiezaDentaria>{

	@Override
    public void insert(PiezaDentaria pieza) throws SQLException {
        String sql = "INSERT INTO PIEZAS_DENTARIAS (NRO_PIEZA, DETALLE, TIPO_DENTICION, GRUPO_DENTARIO, SUBGRUPO, ARCADA, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, pieza.getNroPieza());
            statement.setString(2, pieza.getDetalle());
            statement.setString(3, pieza.getTipoDenticion());
            statement.setString(4, pieza.getGrupoDentario());
            statement.setString(5, pieza.getSubgrupo());
            statement.setString(6, pieza.getArcada());
            statement.setBoolean(7, pieza.setEstado(true));
            statement.executeUpdate();
        }
    }

    @Override
    public void update(PiezaDentaria pieza) throws SQLException {
        String sql = "UPDATE PIEZAS_DENTARIAS SET NRO_PIEZA = ?, DETALLE = ?, TIPO_DENTICION = ?, GRUPO_DENTARIO = ?, SUBGRUPO = ?, ARCADA = ?, ESTADO = ? WHERE ID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, pieza.getNroPieza());
            statement.setString(2, pieza.getDetalle());
            statement.setString(3, pieza.getTipoDenticion());
            statement.setString(4, pieza.getGrupoDentario());
            statement.setString(5, pieza.getSubgrupo());
            statement.setString(6, pieza.getArcada());
            statement.setBoolean(7, pieza.getEstado());
            statement.setInt(8, pieza.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public PiezaDentaria getById(int id) throws SQLException {
        String sql = "SELECT * FROM PIEZAS_DENTARIAS WHERE ID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new PiezaDentaria(
                            resultSet.getInt("ID"),
                            resultSet.getInt("NRO_PIEZA"),
                            resultSet.getString("DETALLE"),
                            resultSet.getString("TIPO_DENTICION"),
                            resultSet.getString("GRUPO_DENTARIO"),
                            resultSet.getString("SUBGRUPO"),
                            resultSet.getString("ARCADA"),
                            resultSet.getBoolean("ESTADO")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<PiezaDentaria> getAll() throws SQLException {
        List<PiezaDentaria> piezas = new ArrayList<>();
        String sql = "SELECT * FROM PIEZAS_DENTARIAS";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                piezas.add(new PiezaDentaria(
                        resultSet.getInt("ID"),
                        resultSet.getInt("NRO_PIEZA"),
                        resultSet.getString("DETALLE"),
                        resultSet.getString("TIPO_DENTICION"),
                        resultSet.getString("GRUPO_DENTARIO"),
                        resultSet.getString("SUBGRUPO"),
                        resultSet.getString("ARCADA"),
                        resultSet.getBoolean("ESTADO")
                ));
            }
        }
        return piezas;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM PIEZAS_DENTARIAS WHERE ID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

}
