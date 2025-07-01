/* Com a declaração "open module app.calculo" estamos dizendo que este módulo
 * esta aberto para todas as classes que o requerirem, sendo possível modificar
 * a visibilidade  e encapsulamento da variáveis privadas através de "reflexão"*/
module app.calculo {

    /*
     * Exportamos os arquvios contidos dentro da pasta "David_Santos_app_calculo",
     * porém suas subpastas não fazem parte desse "export" caso desejar usa-las será
     * necessário exporta-las explicitamente.
     */
    exports David_Santos_app_calculo;

    /* Requirimos as pastas de "app.login" */
    requires app.loggin;

    /*
     * O "export to" serve para exportamos pastas para módulos especificos nesse
     * caso exportamos a pasta "Interno" para o módulo "app.financeiro".
     */
    exports David_Santos_app_calculo.Interno to app.financeiro;

    /*
     * Porém quando utilizamos o "open to" abrimos nosso módulo para apenas um
     * módulo específico não para todos.
     */
    opens David_Santos_app_calculo to app.financeiro;

}