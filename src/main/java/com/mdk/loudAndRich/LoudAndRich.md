# 📘 LoudAndRich — Explication du Code

Cette classe implémente une solution au problème **"Loud and Rich"** :  
Pour chaque personne, on cherche la personne **la plus calme** parmi tous ceux qui sont **plus riches** qu’elle (y compris elle-même).

L’algorithme utilise une **représentation en graphe** et un **DFS avec mémoïsation** pour optimiser les calculs.

---

## 🔍 Objectif du problème

On reçoit :

- Un tableau `richer`, où chaque paire `[a, b]` signifie que **a est plus riche que b**.
- Un tableau `quiet`, où `quiet[i]` donne le **niveau de calme** de la personne `i` (plus petit = plus calme).

Pour chaque personne `i`, on veut trouver **la personne la plus calme** parmi :
- elle-même
- tous ceux qui sont plus riches qu’elle (directement ou indirectement)

Le résultat est stocké dans un tableau où chaque case contient l’indice de la personne la plus calme.

---

## 🏗️ Structure générale de la classe

La classe utilise :

- `graph` : une **liste d’adjacence** où `graph[i]` contient les personnes **plus riches** que `i`.
- `quietnessValues` : le tableau des niveaux de calme.
- `result` : tableau contenant la réponse pour chaque personne, initialisé avec `-1` pour indiquer que les valeurs ne sont pas encore calculées.

---

## 🧱 Construction du graphe

Le graphe est construit selon le principe :

> Si `a` est plus riche que `b`, alors depuis `b` on peut aller vers `a`.

Ainsi, pour un couple `[a, b]`, on fait :  
`graph[b].add(a)`.

Ce graphe permet d’explorer **toute la chaîne des personnes plus riches** via DFS.

---

## 🔄 Utilisation de DFS (Depth-First Search)

Le DFS est utilisé pour déterminer, pour chaque personne :

1. Le calme de cette personne.
2. Le calme de toutes les personnes plus riches.
3. Le plus calme parmi toutes ces options.

Chaque valeur calculée est mémorisée dans `result` pour éviter de recalculer inutilement (**mémoïsation**).

### Étapes du DFS :

- Si `result[currentPerson]` est déjà connu, on ne fait rien.
- Sinon, on initialise :  `result[currentPerson] = currentPerson`

- Pour chaque `richerPerson` dans `graph[currentPerson]` :
- On appelle récursivement `dfs(richerPerson)`
- Si `richerPerson` mène à quelqu’un de plus calme que le résultat actuel, on met à jour.

---

## 🧠 Mémoïsation

La mémoïsation permet d'éviter d'explorer plusieurs fois les mêmes chemins dans le graphe.

`result[i] = -1` signifie que la personne `i` n’a pas encore été traitée.

Lorsqu’une réponse est trouvée, elle est stockée et réutilisée.

---

## ⏱️ Complexité

Grâce à la mémoïsation :

- **Temps : O(N + E)**  
  Où N = nombre de personnes, E = relations "plus riche que".
- **Mémoire : O(N + E)**  
  Pour le graphe, le tableau `result` et la pile du DFS.

---

## 🧪 Résultat final

Le tableau retourné `result` contient, pour chaque personne :

- L’indice de la personne la plus calme
- Parmi toutes les personnes plus riches
- Ou elle-même si aucune personne plus riche n’est plus calme qu’elle.

---

