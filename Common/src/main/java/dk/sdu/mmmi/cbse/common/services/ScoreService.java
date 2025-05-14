package dk.sdu.mmmi.cbse.common.services;

/**
 * Service for submitting game scores.
 */
public interface ScoreService {

    /**
     * Submit a score value (e.g. points for destroying an asteroid).
     *
     * <p><strong>Pre-condition:</strong></p>
     * <ul>
     *     <li>The service endpoint must be available.</li>
     *     <li>{@code value} must be a non-negative integer.</li>
     * </ul>
     *
     * <p><strong>Post-condition:</strong></p>
     * <ul>
     *     <li>The score has been recorded (persisted or enqueued for storage).</li>
     *     <li>An identifier for the submitted score has been generated.</li>
     *     <li>No exception is thrown for valid inputs.</li>
     * </ul>
     *
     * @param value the point value to submit; must be ≥ 0
     * @throws IllegalArgumentException if {@code value} is negative
     */
    void submitScore(int value);
}
