package com.alura.forohub.infra.security;

public record DatosAutenticacionUsuario(
        String login,
        String clave
) {
}
