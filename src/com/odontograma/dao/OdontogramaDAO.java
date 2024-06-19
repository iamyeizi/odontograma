package com.odontograma.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.odontograma.model.Odontograma;
import com.odontograma.model.Paciente;
import com.odontograma.utils.DBConnection;

public class OdontogramaDAO implements BaseDAO<Odontograma>{

	@Override
    public void insert(Odontograma odontograma) throws SQLException {
        String sql = "INSERT INTO ODONTOGRAMA (DESCRIPCION, TIPO_ODONTOGRAMA, ID_PACIENTE) VALUES (?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, odontograma.getDescripcion());
            statement.setString(2, odontograma.getTipoOdontograma());
            statement.setInt(3, odontograma.getPaciente().getId());
            statement.executeUpdate();
        }
    }

	@Override
    public void update(Odontograma odontograma) throws SQLException {
        String sql = "UPDATE ODONTOGRAMA SET DESCRIPCION = ?, TIPO_ODONTOGRAMA = ?, ID_PACIENTE = ? WHERE ID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, odontograma.getDescripcion());
            statement.setString(2, odontograma.getTipoOdontograma());
            statement.setInt(3, odontograma.getPaciente().getId());
            statement.setInt(4, odontograma.getId());
            statement.executeUpdate();
        }
    }

	@Override
    public Odontograma getById(int id) throws SQLException {
        String sql = "SELECT * FROM ODONTOGRAMA o JOIN PACIENTES p ON o.ID_PACIENTE = p.ID WHERE o.ID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Paciente paciente = new Paciente(
                            resultSet.getInt("p.ID"),
                            resultSet.getInt("p.NRODOC"),
                            resultSet.getString("p.TIPODOC"),
                            resultSet.getString("p.NOMBRE"),
                            resultSet.getString("p.APELLIDO"),
                            resultSet.getDate("p.FECHA_NACIMIENTO"),
                            resultSet.getString("p.GENERO"),
                            resultSet.getString("p.DOMICILIO"),
                            resultSet.getString("p.EMAIL"),
                            resultSet.getString("p.TELEFONO")
                    );
                    return new Odontograma(
                            resultSet.getInt("o.ID"),
                            resultSet.getString("o.DESCRIPCION"),
                            resultSet.getString("o.TIPO_ODONTOGRAMA"),
                            paciente
                    );
                }
            }
        }
        return null;
    }

	@Override
    public List<Odontograma> getAll() throws SQLException {
        List<Odontograma> odontogramas = new ArrayList<>();
        String sql = "SELECT * FROM ODONTOGRAMA o JOIN PACIENTES p ON o.ID_PACIENTE = p.ID";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Paciente paciente = new Paciente(
                        resultSet.getInt("p.ID"),
                        resultSet.getInt("p.NRODOC"),
                        resultSet.getString("p.TIPODOC"),
                        resultSet.getString("p.NOMBRE"),
                        resultSet.getString("p.APELLIDO"),
                        resultSet.getDate("p.FECHA_NACIMIENTO"),
                        resultSet.getString("p.GENERO"),
                        resultSet.getString("p.DOMICILIO"),
                        resultSet.getString("p.EMAIL"),
                        resultSet.getString("p.TELEFONO")
                );
                Odontograma odontograma = new Odontograma(
                        resultSet.getInt("o.ID"),
                        resultSet.getString("o.DESCRIPCION"),
                        resultSet.getString("o.TIPO_ODONTOGRAMA"),
                        paciente
                );
                odontogramas.add(odontograma);
            }
        }
        return odontogramas;
    }

	@Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM ODONTOGRAMA WHERE ID = ?";
	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, id);
	            statement.executeUpdate();
	        }
	}
}
