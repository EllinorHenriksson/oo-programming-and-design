package task2;

import java.util.ArrayList;

/**
 * Represents a planet.
 */
public class Planet {
  private String name;
  private int position;
  private int noOfMoons;
  private int aphelion;
  private int perihelion;
  private ArrayList<Moon> moons;

  /**
   * Initializing constructor.
   *
   * @param name The name.
   * @param position The position.
   * @param aphelion The aphelion.
   * @param perihelion The perihelion.
   */
  public Planet(String name, int position, int noOfMoons, int aphelion, int perihelion) {
    setName(name);
    setPosition(position);
    setNoOfMoons(noOfMoons);
    setAphelion(aphelion);
    setPerihelion(perihelion);
    moons = new ArrayList<>();
  }

  /**
   * Gets the name of the planet.
   *
   * @return The name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the planet.
   *
   * @param newName The name (must not be null or shorter than 2 characters, or an exception will be thrown).
   */
  public void setName(String newName) {
    if (newName == null || newName.length() < 2) {
      throw new IllegalArgumentException("Invalid planet name, must not be null or shorter than two characters.");
    } else {
      name = newName;
    }
  }

  /**
   * Gets the position of the planet.
   *
   * @return The position.
   */
  public int getPosition() {
    return position;
  }

  /**
   * Sets the position of the planet.
   *
   * @param newPos The position (must be 1-9, or an exception will be thrown).
   */
  public void setPosition(int newPos) {
    if (newPos > 0 && newPos < 10) {
      position = newPos;
    } else {
      throw new IllegalArgumentException("Invalid planet position, must be within the range 1-9.");
    }
  }

  /**
   * Gets the number of moons of the planet. N.B. Not the same as the length of 'moons'!
   *
   * @return The number of moons.
   */
  public int getNoOfMoons() {
    return noOfMoons;
  }

  /**
   * Sets the number of moons of the planet. N.B. Not the same as the length of 'moons'!
   *
   * @param newCount The number of moons (must be 0 or more, or an exception will be thrown).
   */
  public void setNoOfMoons(int newCount) {
    if (newCount < 0) {
      throw new IllegalArgumentException("Invalid number of moons, must be 0 or more.");
    } else {
      noOfMoons = newCount;
    }
  }

  /**
   * Gets the aphelion of the planet.
   *
   * @return The aphelion.
   */
  public int getAphelion() {
    return aphelion;
  }

  /**
   * Sets the aphelion of the planet.
   *
   * @param newAphelion The aphelion (must be larger than 0, or an exception will be thrown).
   */
  public void setAphelion(int newAphelion) {
    if (newAphelion > 0) {
      aphelion = newAphelion;
    } else {
      throw new IllegalArgumentException("Invalid aphelion, must be larger than 0.");
    }
  }

  /**
   * Gets the perihelion of the planet.
   *
   * @return The perihelion.
   */
  public int getPerihelion() {
    return perihelion;
  }

  /**
   * Sets the perihelion of the planet.
   *
   * @param newPerihelion The perihelion (must be larger than 0, or an exception will be thrown).
   */
  public void setPerihelion(int newPerihelion) {
    if (newPerihelion > 0) {
      perihelion = newPerihelion;
    } else {
      throw new IllegalArgumentException("Invalid perihelion, must be larger than 0.");
    }
  }

  /**
   * Adds a moon to the planet.
   *
   * @param newMoon The moon (must be a unique object with a unique name, or an exception will be thrown).
   */
  public void addMoon(Moon newMoon) {
    boolean isUnique = true;
    for (Moon m : moons) {
      if (m == newMoon || m.getName().equals(newMoon.getName())) {
        isUnique = false;
      }
    }

    if (isUnique) {
      moons.add(newMoon);
      noOfMoons = moons.size();
    } else {
      throw new IllegalArgumentException("Moon already added to planet.");
    }
  }

  /**
   * Gets an array with copies of the Moon objects that the planet holds.
   *
   * @return The moon copies.
   */
  public Moon[] getMoons() {
    Moon[] copy = new Moon[moons.size()];

    for (int i = 0; i < moons.size(); i++) {
      copy[i] = new Moon(moons.get(i).getName(), moons.get(i).getSizeInKm());
    }

    return copy;
  }

  /**
   * Returns a string representing the planet.
   *
   * @return A string.
   */
  @Override
  public String toString() {
    return name
        + ":\n  Position: " + position
        + "\n  Moons: " + noOfMoons
        + "\n  Aphelion: " + aphelion + " km"
        + "\n  Perihelion: " + perihelion + " km";
  }
}
