
# 📘 EvaluateDivision

## 🎯 Objectif

Ce projet implémente une solution pour évaluer des divisions entre variables à partir d’équations du type :

a / b = 2.0

b / c = 3.0

L’objectif est de répondre à des requêtes comme :

a / c = ?

c / a = ?

x / y = ? (si inconnus → -1.0)

---

## 🧠 Approche : Union-Find pondéré (Weighted DSU)

Pour représenter les relations entre les variables, on utilise une structure **Union-Find** (ou DSU – Disjoint Set Union) enrichie avec des **poids**.

Chaque variable est un nœud, et chaque équation crée une relation orientée avec un ratio.  
Le DSU permet de déterminer rapidement si deux variables sont connectées, et de calculer leur ratio.

### 🔍 Représentation
- `parent[x]` : le parent direct de `x`
- `weight[x]` : le ratio entre `x` et son parent  
  (exemple : si `a / b = 2`, alors `parent[a] = b` et `weight[a] = 2`)

---

## 🔧 Étapes de la solution

### **1. Initialisation**
Chaque variable devient son propre parent, avec un poids de 1.0.

### **2. Union**
Pour chaque équation `a / b = value` :
- on fusionne les ensembles contenant `a` et `b`
- on met à jour les poids pour maintenir la cohérence des ratios

### **3. Path Compression**
Lors d’un `find(x)` :
- on remonte jusqu'à la racine
- on compresse le chemin
- on met à jour les poids cumulés  
  → améliore fortement les performances

### **4. Résolution des requêtes**
Pour une requête `x / y` :
- si `x` ou `y` n’existent pas → `-1.0`
- si `x` et `y` n’appartiennent pas au même ensemble → `-1.0`
- sinon :
- résultat = weight[x] / weight[y]
