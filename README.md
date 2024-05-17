# Simulation de Gestion du Passeport et Visa

Ce projet est une simulation de gestion du passeport et du visa d'une personne. Il permet de demander, prolonger, et annuler des passeports et des visas, tout en assurant que les dates de validité sont cohérentes et respectées.

## Auteur

- **Evgenii Morgunov**

## Version Java

- **Version Java 21**

## Dépôt GitHub

- [Simulation de gestion du passeport et visa](https://github.com/MorgunovE/Simulation-de-gestion-du-passeport-et-visa)

## Fonctionnalités

- **Demande de passeport :** Permet à une personne de demander et d’obtenir un passeport.
- **Demande de visa :** Permet à une personne de demander et d’obtenir un visa associé à un passeport.
- **Affichage des informations :** Affiche les informations personnelles, les détails du passeport et les détails des visas d'une personne.
- **Prolongation du passeport :** Permet de prolonger la date d’expiration d’un passeport.
- **Prolongation du visa :** Permet de prolonger la date d’expiration d’un visa.
- **Annulation du passeport :** Annule un passeport et les visas associés en cas de vol ou de perte.
- **Annulation du visa :** Permet d'annuler un visa.
- **Vérification annuelle :** Un processus automatique vérifie annuellement la validité et la date d’expiration des passeports et visas.

## Structure du Projet

- **Component :**
    - `Personne` : Représente une personne avec ses informations personnelles.
    - `Passeport` : Représente un passeport avec ses détails et visas associés.
    - `Visa` : Représente un visa avec ses détails.

- **Service :**
    - `ServicePasseport` : Gère les opérations liées aux passeports.
    - `ServiceConsulaire` : Gère les opérations liées aux visas.

## Installation

1. **Cloner le dépôt :**
   ```bash
   git clone https://github.com/MorgunovE/Simulation-de-gestion-du-passeport-et-visa.git
   cd Simulation-de-gestion-du-passeport-et-visa
    ```
2. **Compiler le projet :**
   ```bash
   javac -d bin src/Component/*.java src/Service/*.java
    ```

3. **Exécuter le projet :**
   ```bash
   java -cp bin Main
    ```
   
## Utilisation

**Création et gestion des passeports et visas d'une personne:**

L'interface utilisateur permet de :
1. Demander et obtenir un passeport. 
2. Demander et obtenir un visa. 
3. Afficher les informations d'une personne, y compris les détails du passeport et des visas. 
4. Prolonger la date d'expiration d'un passeport ou d'un visa. 
5. Annuler un passeport ou un visa.

**Simulation de scénarios :**

**1. Situation d’invalidité de passeport :**
- `Simuler une situation où un passeport est invalide suite à un vol ou une perte.`
- `Suivre les directives pour invalider le visa associé.`

**2. Prolongation de la date d’expiration :**
- `Simuler une demande de prolongation de la date d’expiration du visa.`
- `Simuler une demande de prolongation de la date d’expiration du passeport.`


## Processus Automatique

Le service des passeports propose une nouvelle plateforme qui permet, moyennant des frais supplémentaires, l'activation automatique d'une demande de prolongation de visa sur un passeport pour lequel une demande de prolongation de la date d'expiration est soumise.

## Vérification Annuelle

La processus automatique annuel vérifie la validité et la date d’expiration des passeports des citoyens chaque année le 31 décembre.
