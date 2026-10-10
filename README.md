# SpielerUmriss

Clientseitige Fabric-Mod fuer Minecraft Java 1.21.11. Solange sie eingeschaltet ist, erhalten andere Spieler, die dein Client kennt, einen pinken Minecraft-Umriss. Die Mod ist standardmaessig mit **K** belegt; die Taste kann unter **Optionen > Steuerung > Tastenbelegung** geaendert werden.

## Voraussetzungen

- Minecraft Java 1.21.11
- Fabric Loader 0.18.4 oder neuer
- Fabric API fuer Minecraft 1.21.11
- Java 21 zum Bauen
- Gradle 9.5.0 (wird im GitHub-Workflow verwendet)

## Lokal bauen

Im Projektordner:

```powershell
gradle build
```

Die spielbare Mod-JAR liegt danach unter `build/libs/spielerumriss-1.0.0.jar`. Nicht die Datei mit `-sources` im Namen installieren.

## Mit GitHub Actions bauen

Lade den gesamten Inhalt dieses Projektordners in dein GitHub-Repository hoch, einschliesslich `.github/workflows/build.yml`. Bei Push, Pull Request oder manuellem Start baut GitHub die Mod. Die fertige JAR findest du im erfolgreichen Workflow-Lauf unten im Bereich **Artifacts** unter `spielerumriss-1.21.11`.

## Verhalten

- Der Umriss wird nur fuer andere Spieler angezeigt, nicht fuer dich selbst.
- Die Mod arbeitet auf deinem Client und muss nicht auf dem Server installiert werden.
- Die Mod markiert nur Spieler, die Minecraft deinem Client bereits uebermittelt hat; sie kann keine versteckten oder nicht geladenen Spieler sichtbar machen.
- Der Standard-Umriss ist pink. Andere clientseitige Mods oder Shader, die das Entity-Rendering bzw. Glow-Rendering ersetzen, koennen die Darstellung beeinflussen.
