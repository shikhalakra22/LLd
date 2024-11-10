package Restaurant;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private int rating;
    private String comment;
    private String userId;

}
