module flip_checker(sy,c1,c2,c3,clk,v);
input clk;
input [2:0]sy;
input [5:0]c1,c2,c3;
output reg [5:0]v;
always@(clk)
begin
case(sy)
 3'b110:
  begin
     v[0]=~(c1[0]^c2[0]);
     v[1]=~(c1[1]^c2[1]);
     v[2]=~(c1[2]^c2[2]);
     v[3]=~(c1[3]^c2[3]);
     v[4]=~(c1[4]^c2[4]);
     v[5]=~(c1[5]^c2[5]);
  end
 3'b101:
  begin
     v[0]=~(c1[0]^c3[0]);
     v[1]=~(c1[1]^c3[1]);
     v[2]=~(c1[2]^c3[2]);
     v[3]=~(c1[3]^c3[3]);
     v[4]=~(c1[4]^c3[4]);
     v[5]=~(c1[5]^c3[5]);
  end
 3'b011:
  begin
     v[0]=~(c3[0]^c2[0]);
     v[1]=~(c3[1]^c2[1]);
     v[2]=~(c3[2]^c2[2]);
     v[3]=~(c3[3]^c2[3]);
     v[4]=~(c3[4]^c2[4]);
     v[5]=~(c3[5]^c2[5]);
  end
endcase
end  
endmodule   