
# Projet "Dice" - Gestion de lancés de dés avec Spring Boot

## Description
Le projet "Dice" est une application construite avec Spring Boot pour simuler des lancés de dés et gérer un historique des résultats enregistrés dans une base de données.


## Étapes de réalisation

### 1. Création du projet Spring Boot (fait)
- Utilisez [Spring Initializr](https://start.spring.io/) pour créer le projet.
- Choisissez la dernière version de Spring Boot disponible (LTS).
- Optez pour **Maven** ou **Gradle** comme outil de gestion de dépendances.
- Ajoutez les dépendances nécessaires : **Spring Web**, **Spring Data JPA**, **H2 Database** .

### 2. Configuration du projet (fait)
- Configurez l'application pour qu'elle utilise le port **8081**.
- Donnez un nom (**dice**) au projet dans le fichier de configuration :
  - Utilisez **`application.properties`** ou **`application.yml`** selon votre préférence.

### 3. Création de la classe `Dice` (fait)
- Implémentez une classe représentant un dé avec les méthodes nécessaires pour effectuer un lancé.
- Marquez cette classe avec l'annotation `@Component` pour pouvoir l'injecter au besoin.

### 4. Création de l'entité `DiceRollLog` (fait)
- Modélisez une entité JPA `DiceRollLog` comprenant les champs suivants :
  - **`id`** : Identifiant unique.
  - **`diceCount`** : Nombre de dés lancés.
  - **`results`** : Liste ou chaîne des valeurs obtenues. Il existe de nombreuses façons de stocker des valeurs simples (simple String), certaines sont plus élégantes (@ElementCollection) que d'autres, vous pouvez choisir la solution qui vous conviendra.
  - **`timestamp`** : Horodatage du lancé.
- Utilisez des annotations JPA comme `@Entity`, `@Id`, `@GeneratedValue`, etc.

### 5. Création du `Repository` (fait)
- Implémentez une interface héritant de `JpaRepository<DiceRollLog, Long>` pour gérer les interactions avec la base de données.

### 6. Création du contrôleur REST pour lancer les dés (fait)
- Implémentez un contrôleur REST annoté avec `@RestController`.
- Ajoutez les endpoints suivants :
  - **`GET /rollDice`** : Lancer un seul dé.
  - **`GET /rollDices/{X}`** : Lancer X dés (X étant un paramètre dynamique).

### 7. Création du `Service` (fait)
- Créez un service marqué avec `@Service` contenant une méthode :
  - Prend en paramètre le nombre de dés à lancer.
  - Retourne les résultats des lancés au contrôleur.
  - Enregistre l’historique des lancés dans la base via le `Repository`.

### 8. Contrôleur pour afficher les historiques (fait)
- Ajoutez un autre contrôleur REST permettant d'afficher l'historique des lancés :
  - **`GET /diceLogs`** : Retourne tous les enregistrements de `DiceRollLog` au format JSON.

### 9. Tests et validation (fait)
- Démarrez l'application et testez les endpoints.
- Vérifiez les résultats dans la base de données et les réponses JSON.

### 10. (Bonus) Ajout de fonctionnalités avancées
- **Swagger** : (je n'ai pas réussi à ajouter Swagger
  - Ajoutez la dépendance Swagger/OpenAPI.
  - Configurez Swagger pour documenter vos endpoints.
  - Accédez à la documentation sur **`http://localhost:8081/swagger-ui.html`**.
- **Lombok** : (ajout de cette fonctionnalité)
  - Utilisez Lombok pour simplifier les getters, setters et constructeurs de vos entités.

---

#### Base de données

Une console H2 est disponible pour visualiser et interagir avec la base de données :

URL : http://localhost:8081/h2-console

JDBC URL : jdbc:h2:mem:testdb

Nom d'utilisateur : sa

Mot de passe : (laissé vide par défaut)

#### Tests

# Lancer un dé simple :

GET http://localhost:8081/api/dice/rollDice

# Lancer plusieurs dés :

GET http://localhost:8081/api/dice/rollDices/3

# Voir l'historique des lancés :

GET http://localhost:8081/api/logs/diceLogs

#### Auteur 

- Nom : Chloé TANGHE
- Promo : M1 MIAGE


## Technologies
- **Framework principal** : Spring Boot
- **Base de données** : H2 
- **Simplification de code** : Lombok (bonus)


