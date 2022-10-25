# TP 2 — Sujet 1 : Quizz _du futur_


## But

Concevoir un service RMI.


## Spécifications

Vous venez de rejoindre une startup avec une idée révolutionnaire : proposer un service permettant de faire des Quizz !

Dans l'équipe, vous êtes en charge de développer le modèle de ce service, et de permettre son utilisation en réseau (à l'aide de RMI).

Le service doit proposer les fonctionnalités suivantes :
- **S'inscrire** au service, à l'aide d'un `pseudo`.
  - Le _pseudo_ doit être unique (deux personnes inscrites ne peuvent pas avoir le même pseudo).
- **Ajouter** une nouvelle question, composée d'un `intitulé` et de `4 propositions de réponse`.
  - _L'ajout d'une question n'est possible que pour une personne inscrite au service_.
  - Aucun contrôle n'est à faire sur d'éventuels doublons de questions. 
- **Répondre** à une question (un unique choix parmi les 4 propositions de réponse).
  - _La réponse à une question n'est possible que pour une personne inscrite_.
  - Une personne inscrite ne peut répondre qu'_une seule fois_ à une question donnée.
- **Consulter** le détail de toutes les questions : on veut récupérer son _intitulé_, les _4 propositions de réponse_, et la _répartition des réponses données_.

Seules les personnes inscrites peuvent ajouter une question ou y répondre.
Les autres fonctionnalités sont accessibles sans identification.

_Toute ressemblance avec un service de quizz existant est purement fortuite._
    

## Travail demandé

1. **Décomposition du projet**
   - Identifier et créer les projets Maven nécessaires à la réalisation de ce service avec RMI.

1. **Serveur RMI**
   1. Modéliser et implémenter le modèle correspondant aux spécifications demandées.
      - _Remarque :_ l'implémentation doit permettre d'utiliser ce modèle dans le cadre d'un service RMI.
   2. Implémenter un service RMI exposant le modèle.
   3. Écrire un programme principal publiant le service dans un annuaire RMI.

2. **Client RMI**
   - Écrire un programme principal récupérant le service dans l'annuaire RMI, et permettant de tester les différentes fonctionnalités du service :
      - Inscription de quelques personnes.
      - Création de nouvelles questions (par différentes personnes).
      - Réponses à plusieurs questions (par différentes personnes).
      - Consultation du détail de toutes les questions.
