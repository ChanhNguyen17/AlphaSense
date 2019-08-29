# AlphaSense Challenges
1. Coding task 1. Longest substring without repeating characters.
    - Given a string, find the length of the longest substring without repeating characters.
2. Coding task 2. Find subarray with given sum.
    - Given an unsorted array of non-negative integers. Write a function which returns true
  if there is a continuous subarray which adds to a given number (target sum).
  Estimate the complexity of your code.
3. Java: List all issues you can find in the following class:
```
import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

public abstract class Digest {
    private Map<byte[], byte[]> cache = new HashMap<byte[], byte[]>();
    public byte[] digest(byte[] input) {
        byte[] result = cache.get(input);
        if (result == null) {
            synchronized (cache) {
                result = cache.get(input);
                if (result == null) {
                    try {
                        result = doDigest(input);
                        cache.put(input, result);
                    } catch (RuntimeException ex) {
                        LoggerFactory.getLogger("Digest").error(
                                "Unable to make digest"
                        );
                        throw ex;
                    }
                }
            }
        }
        return result;
    }
    protected abstract byte[] doDigest(byte[] input);
}
```
- HashMap explicit type argument <byte[], byte[]> can be replaced with <>
- Synchronization on a non-final field 'cache'
- protected can changed to package-private (remove protected) in method doDigest()
- line 12 "result = cache.get(input);" is repeated line 9 "byte[] result = cache.get(input);", we can remove line 12
- line 13 checked "if (result == null)" again, when we already checked it on line 10
- We can make 'synchronized' the whole method 'digest' instead of block 'synchronized' => code reduction