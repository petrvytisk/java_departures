# Departures (Odlety)

## Přehled

Aplikace **Departures** slouží k získávání a zobrazování informací o odletech leteckých spojů z vybraného letiště prostřednictvím OpenSky Network API. Projekt nabízí:

* **REST API** pro strohé dotazy
* **Webové UI** postavené na Spring MVC + Thymeleaf
* Automatickou konverzi časů mezi `LocalDateTime` a Unix timestamp (UTC)

## Technické požadavky

* **JDK 21** nebo novější
* **Apache Maven 3.8+**
* **Internetové připojení** (pro volání OpenSky Network API)

## Strukturální přehled

```text
src/
 ├─ main/
 │   ├─ java/cz/petrvytisk/Departures/
 │   │   ├─ connector/OpenSkyConnector.java     # Volání externího API
 │   │   ├─ controller/DepartureController.java # REST controller
 │   │   ├─ web/DepartureWebController.java     # Web controller + formulář
 │   │   ├─ service/DepartureService.java       # Obchodní logika
 │   │   ├─ dto/DepartureDto.java               # DTO pro OpenSky odpověď
 │   │   ├─ dto/DepartureSearchForm.java        # Form backing bean
 │   │   └─ util/TimeConverter.java             # Konverze časů
 │   └─ resources/
 │       ├─ application.properties              # Konfigurace Spring Boot
 │       └─ templates/
 │           ├─ odlety_form.html                # Thymeleaf šablona formuláře
 │           └─ odlety_list.html                # Thymeleaf šablona výsledků
 └─ pom.xml                                     # Maven konfigurace
```

## Sestavení projektu

V kořenovém adresáři projektu spusťte:

```bash
mvn clean package
```

Po úspěšném buildnutí se vytvoří spustitelný JAR v `target/Departures-0.0.1-SNAPSHOT.jar`.

## Spuštění aplikace

1. **Přímo v konzoli**:

   ```bash
   java -jar target/Departures-0.0.1-SNAPSHOT.jar
   ```
2. **Z IDE**:

   * Naimportujte Maven projekt
   * Spusťte třídu `cz.petrvytisk.Departures.DeparturesApplication`

Aplikace poběží na výchozím portu **8080**.

## Konfigurace

V souboru `src/main/resources/application.properties` můžete upravit následující hodnoty:

```properties
# Port, na kterém aplikace naslouchá
server.port=8080

# Základní URL OpenSky API (lze předefinovat)
opensky.base-url=https://opensky-network.org/api
```

> **Tip:** Pokud potřebujete změnit formát či lokalizaci, můžete doplnit další Spring Boot vlastnosti.

## REST API

### GET /odlety

Endpoint pro získání seznamu odletů.

**Parametry (query string):**

| Název   | Popis                                     | Formát               | Povinné |
| ------- | ----------------------------------------- | -------------------- | ------- |
| letiste | ICAO kód letiště (např. `LKPR`, `EDDF`)   | *string*             | ano     |
| od      | Počátek periody ve formátu `yyyyMMddHHmm` | *např. 202501241530* | ano     |
| do      | Konec periody ve formátu `yyyyMMddHHmm`   | *např. 202501241630* | ano     |

**Příklad volání (cURL):**

```bash
curl "http://localhost:8080/odlety?letiste=LKPR&od=202501241530&do=202501241630"
```

**Odpověď:** JSON pole `DepartureDto` objektů.

## Webové uživatelské rozhraní

### Formulář pro vyhledávání

* **URL:** `http://localhost:8080/odletyapp`
* **Pole:**

  * `airport` (ICAO)
  * `from` (lokální datum/čas, formát `yyyy-MM-dd'T'HH:mm`)
  * `to`   (lokální datum/čas, formát `yyyy-MM-dd'T'HH:mm`)

Vyplněním a odesláním formuláře se zobrazí tabulka nalezených odletů.

## Dokumentace API (OpenAPI / Swagger)

Projekt je vybaven **SpringDoc**. Po spuštění najdete dokumentaci na:

* Swagger UI: `http://localhost:8080/swagger-ui/index.html`
* Raw OpenAPI JSON: `http://localhost:8080/v3/api-docs`

---

**Autor:** Petr Vytisk
**Verze:** 0.0.1-SNAPSHOT
