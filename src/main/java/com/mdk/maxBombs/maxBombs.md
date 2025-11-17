# 💣 MaxBombs – Calcul du nombre maximal de bombes déclenchées

## 🎯 Objectif

Le projet vise à déterminer le **nombre maximal de bombes pouvant être déclenchées en chaîne** à partir d’une liste de bombes disposées sur un plan 2D.  
Chaque bombe est caractérisée par sa position `(x, y)` et son rayon d’explosion.

Une bombe peut déclencher une autre si celle-ci se trouve à une distance inférieure ou égale à son rayon. L’objectif est donc de simuler la propagation des explosions et de trouver le scénario qui déclenche le plus de bombes.

---

## 🧠 Approche

L’approche utilisée se divise en deux étapes principales :

### 1. Construction du graphe des explosions

- Chaque bombe est considérée comme un **nœud** dans un graphe.
- Une **arête orientée** relie deux bombes si la première peut déclencher la seconde en respectant son rayon d’explosion.
- Le graphe représente toutes les relations possibles entre les bombes pour la propagation de l’explosion.

### 2. Parcours du graphe pour déterminer le maximum d’explosions

- Pour chaque bombe du graphe, un **parcours en profondeur (DFS)** ou en largeur (BFS) est effectué afin de simuler toutes les explosions en chaîne possibles.
- À chaque parcours, on compte le nombre de bombes déclenchées.
- On conserve le maximum sur tous les départs possibles pour obtenir le nombre maximal de bombes pouvant exploser en cascade.

Cette approche permet de simuler efficacement les interactions entre bombes et de déterminer le scénario optimal sans vérifier toutes les combinaisons manuellement.

---

## 📌 Exemple conceptuel

Supposons trois bombes avec les rayons et positions suivants :

- Bombe A : `(0,0)` rayon 3
- Bombe B : `(1,1)` rayon 2
- Bombe C : `(5,5)` rayon 1

Dans ce cas :

- Bombe A peut déclencher B
- Bombe B ne peut pas déclencher A
- Bombe C n’est dans le rayon d’aucune bombe

En simulant les explosions avec DFS depuis chaque bombe, on constate que le nombre maximal de bombes déclenchées en chaîne est 2 (A → B).

---

## ✔️ Avantages de cette approche

- Permet de gérer **n’importe quelle disposition de bombes** sans avoir à tester toutes les combinaisons.
- Le DFS assure que toutes les explosions en chaîne à partir de chaque bombe sont correctement explorées.
- Structure simple et extensible, adaptable à des scénarios plus complexes avec de nombreuses bombes.

---

## 👤 Auteur

Projet développé par **Mahmoud DKHISSI**
