module hamming_distance(binary1, binary2,  distance);
input [5:0] binary1;
input [5:0] binary2;
integer i;
output reg [1:0]distance;
  always @(*) 
begin
 distance=2'b00;
    for (i = 0; i < 6; i = i + 1)
 begin
      if (binary1[i] != binary2[i])
        distance = distance + 1;
    end  
  end
endmodule