# 🌦️ Climate Data Reader

Uma aplicação Java de console robusta para consulta de dados meteorológicos em tempo real. O projeto demonstra a aplicação de boas práticas de Engenharia de Software, incluindo **Padrões de Projeto (Design Patterns)**, **Arquitetura Limpa** e manipulação segura de recursos.

## 🚀 Sobre o Projeto

Este sistema permite que o usuário consulte o clima de qualquer cidade do mundo através do terminal. A aplicação consome a [WeatherAPI](https://www.weatherapi.com/), processa os dados brutos (JSON) e os apresenta de forma legível e formatada.

O diferencial deste projeto é a sua arquitetura desacoplada, separando a resposta da API externa do modelo de domínio da aplicação.

## 🛠️ Tecnologias Utilizadas

- **Java 23**
- **Maven** (Gerenciamento de dependências)
- **Gson 2.10.1** (Parsing de JSON)
- **Java HTTP Client** (`java.net.http`)

---

## 🏛️ Arquitetura e Padrões de Projeto

O projeto foi construído com foco em manutenibilidade e legibilidade. Abaixo estão os principais conceitos aplicados:

### 1. Data Transfer Objects (DTOs) com Java Records

Para garantir a imutabilidade na transferência de dados e separar a estrutura "suja" do JSON externo da lógica de negócio, foram utilizados **Java Records**. O mapeamento é feito via anotações da biblioteca **Gson** (`@SerializedName`).

- **Localização:** `src/main/java/org/climate_data_api/DTO/`

```java
// Exemplo de DTO aninhado (WeatherResponseDTO.java)
public record WeatherResponseDTO(
        @SerializedName("location")
        LocationDTO location,

        @SerializedName("current")
        CurrentDTO current
) {}
```

### 2. Builder Pattern

Para resolver o problema de construtores complexos (_Telescoping Constructor_) e garantir a criação de objetos de domínio válidos, foi implementado o padrão **Builder** na classe `Climate`. Isso permite uma criação de objetos fluente e legível no `ClimateMapper`.

- **Arquivo:** `src/main/java/org/climate_data_api/model/Climate.java`

```java
// Utilização no ClimateMapper
return new Climate.Builder()
        .city(dto.location().name())
        .weatherCondition(dto.current().condition().text())
        .currentTemperature(dto.current().tempC())
        .build();
```

### 3. Configuração Segura (ClassLoader & InputStream)

A API Key não fica "hardcoded" no código fonte. A classe `ConfigLoader` utiliza `ClassLoader` e `InputStream` para ler o arquivo `api-key.txt` da pasta resources, garantindo que a aplicação funcione corretamente tanto na IDE quanto empacotada em JAR.

- **Arquivo:** `src/main/java/org/climate_data_api/config/ConfigLoader.java`

```java
public String getApiKey() {
    // Leitura agnóstica ao sistema operacional via Stream
    try (InputStream inputStream = classLoader.getResourceAsStream("api-key.txt")) {
        if (inputStream == null) throw new RuntimeException("File not found.");
        return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8).trim();
    }
}
```

## ⚙️ Como Executar o Projeto

### Pré-requisitos

- **Java JDK 23** instalado.
- **Maven** instalado.
- Obter uma chave de API gratuita em [WeatherAPI.com](https://www.weatherapi.com/).

### Passo a Passo

1. **Clone o repositório:**

```bash
   git clone [https://github.com/seu-usuario/climate-data-api.git](https://github.com/seu-usuario/climate-data-api.git)
   cd climate-data-api
```

2. **Configurar a API Key:**

- Navegue até a pasta `src/main/resources/`.
- Crie um arquivo chamado `api-key.txt`.
- Cole sua chave da WeatherAPI dentro dele (apenas a chave, sem espaços).

3. **Compilar e Rodar:**
   Execute o comando Maven na raiz do projeto:

```bash
   mvn clean compile exec:java -Dexec.mainClass="org.climate_data_api.Main"
```
