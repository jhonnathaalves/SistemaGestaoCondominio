package com.jhonnatha.sgc.config;

import com.jhonnatha.sgc.domain.enums.Perfil;

public class TipoPerfilConverter {
	
	public String convertToEnumString(Perfil perfil) {
        switch (perfil) {
           case ROLE_ADMIN:
               return "ROLE_ADMIN";

           case ROLE_USER:
               return "ROLE_USER";
           
           case ROLE_COLABORADOR:
               return "ROLE_COLABORADOR";

           default:
               throw new IllegalArgumentException("O perfil [" + perfil
                       + "] não é suportada.");
        }

   }	

}
