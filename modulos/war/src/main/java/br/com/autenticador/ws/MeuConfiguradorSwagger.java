package br.com.autenticador.ws;

import br.com.gruposaga.cad.wss.ConfiguradorSwagger;

public class MeuConfiguradorSwagger extends ConfiguradorSwagger
{
    @Override
    public String getResourcePackage ()
    {
        return "br.com.gruposaga.cad.autenticar.ws.api";
    }

    @Override
    public String getVersao ()
    {
        return "1.0.0";
    }

    @Override
    public String getRaiz ()
    {
        return "autenticar";
    }
}
