public record ArtesaoCreateDTO(

    @NotBlank String nome,
    String telefone,
    @NotBlank String identificacao,
    @NotBlank String email,
    @NotBlanck String senha
    
) {}