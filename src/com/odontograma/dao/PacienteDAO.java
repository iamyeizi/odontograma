package com.odontograma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.odontograma.model.Paciente;
import com.odontograma.model.PiezaDentaria;
import com.odontograma.utils.DBConnection;

public class PacienteDAO implements BaseDAO<Paciente>{

	@Override
    public void insert(Paciente paciente) throws SQLException {
        String sql = "INSERT INTO PACIENTES (NRODOC, TIPODOC, NOMBRE, APELLIDO, FECHA_NACIMIENTO, GENERO, DOMICILIO, EMAIL, TELEFONO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, paciente.getNroDoc());
            statement.setString(2, paciente.getTipoDoc());
            statement.setString(3, paciente.getNombre());
            statement.setString(4, paciente.getApellido());
            statement.setDate(5, paciente.getFechaNacimiento());
            statement.setString(6, paciente.getGenero());
            statement.setString(7, paciente.getDomicilio());
            statement.setString(8, paciente.getEmail());
            statement.setString(9, paciente.getTelefono());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Paciente paciente) throws SQLException {
        String sql = "UPDATE PACIENTES SET NRODOC = ?, TIPODOC = ?, NOMBRE = ?, APELLIDO = ?, FECHA_NACIMIENTO = ?, GENERO = ?, DOMICILIO = ?, EMAIL = ?, TELEFONO = ? WHERE ID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, paciente.getNroDoc());
            statement.setString(2, paciente.getTipoDoc());
            statement.setString(3, paciente.getNombre());
            statement.setString(4, paciente.getApellido());
            statement.setDate(5, paciente.getFechaNacimiento());
            statement.setString(6, paciente.getGenero());
            statement.setString(7, paciente.getDomicilio());
            statement.setString(8, paciente.getEmail());
            statement.setString(9, paciente.getTelefono());
            statement.executeUpdate();
        }
    }

    @Override
    public Paciente getById(int id) throws SQLException {
        String sql = "SELECT * FROM PACIENTES WHERE ID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Paciente(
                            resultSet.getInt("ID"),
                            resultSet.getInt("NRODOC"),
                            resultSet.getString("TIPODOC"),
                            resultSet.getString("NOMBRE"),
                            resultSet.getString("APELLIDO"),
                            resultSet.getDate("FECHA_NACIMIENTO"),
                            resultSet.getString("GENERO"),
                            resultSet.getString("DOMICILIO"),
                            resultSet.getString("EMAIL"),
                            resultSet.getString("TELEFONO")

                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Paciente> getAll() throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
//        String sql = "SELECT * FROM PIEZAS_DENTARIAS";
        // try (Connection connection = DBConnection.getConnection();
        //      PreparedStatement statement = connection.prepareStatement(sql);
        //      ResultSet resultSet = statement.executeQuery()) {
        //     while (resultSet.next()) {
                // pacientes.add(new Paciente(
//                        resultSet.getInt("ID"),
//                        resultSet.getInt("NRO_PIEZA"),
//                        resultSet.getString("DETALLE"),
//                        resultSet.getString("TIPO_DENTICION"),
//                        resultSet.getString("GRUPO_DENTARIO"),
//                        resultSet.getString("SUBGRUPO"),
//                        resultSet.getString("ARCADA"),
//                        resultSet.getBoolean("ESTADO")
                // ));
            // }
        // }
        return pacientes;
    }

    @Override
    public void delete(int id) throws SQLException {
//        String sql = "DELETE FROM PIEZAS_DENTARIAS WHERE ID = ?";
//         try (Connection connection = DBConnection.getConnection();
//              PreparedStatement statement = connection.prepareStatement(sql)) {
//                 statement.setInt(1, id);
//                 statement.executeUpdate();
//         }
    }

}
