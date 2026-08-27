public record ArtesaoCreateDTO(

    @NotBlank String nome,
    @NotBlank String telefone,
    @NotBlank String identificacao,
    @NotBlank String email,
    @NotBlank String senha
    
) {}