jQuery(document).ready(function ($) {
    $("#acompanhamentoProcessual").click(function () {

        var formulario = document.createElement("FORM");
        formulario.action = '/AreaRestrita/ProcessoCliente.do';
        formulario.method = 'POST';
        var usuario = document.getElementById("#entidadeid").getAttribute("value");

        var inputText = document.createElement("INPUT");
        inputText.setAttribute("type", "hidden");
        inputText.setAttribute("value", usuario);
        inputText.setAttribute("id", "form-cliente-id");
        inputText.setAttribute("name", "form-cliente-id");
        formulario.appendChild(inputText);

        var inputButton = document.createElement("INPUT");
        inputButton.setAttribute("type", "hidden");
        inputButton.setAttribute("value", "CONSULTAR");
        inputButton.setAttribute("id", "operacao");
        inputButton.setAttribute("name", "operacao");
        formulario.appendChild(inputButton);
        alert(formulario.value);
        document.body.appendChild(formulario);

        formulario.submit();
    });

    // Exibe ou oculta o botão
    jQuery(window).scroll(function () {
        if (jQuery(this).scrollTop() > 200) {
            jQuery('.voltar-ao-topo').fadeIn(200);
        } else {
            jQuery('.voltar-ao-topo').fadeOut(200);
        }
    });

    // Faz animação para subir
    jQuery('.voltar-ao-topo').click(function (event) {
        event.preventDefault();
        jQuery('html, body').animate({scrollTop: 0}, 300);
    });
});