package Modelo;

import java.util.Date;

public class Persona {
    
    private int codigo;
    private String cedula;
    private String nombre;
    private String apellidos;
    private String foto;
    private int rol;
    private String departamento;
    private String puesto;
    private java.util.Date fechaRegistro = new java.util.Date();
//    private java.util.Date fechaRegistro;
    private String jefeDirecto;
    private int estado;

    @Override
    public String toString() {
        return String.format("%s[codigo=%d]", getClass().getSimpleName(), getCodigo());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos.toUpperCase();
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento.toUpperCase();
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto.toUpperCase();
    }

    public Date getFechaRegistro() {
        java.sql.Date sqlDate = new java.sql.Date(fechaRegistro.getTime());
        return sqlDate;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public String getJefeDirecto() {
        return jefeDirecto;
    }

    public void setJefeDirecto(String jefeDirecto) {
        this.jefeDirecto = jefeDirecto.toUpperCase();
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
