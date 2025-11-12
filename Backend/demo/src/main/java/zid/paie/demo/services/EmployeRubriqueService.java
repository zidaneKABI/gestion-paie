package zid.paie.demo.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import zid.paie.demo.repository.EmployeRubriqueRepository;

@Service
@RequiredArgsConstructor
public class EmployeRubriqueService {

    private final EmployeRubriqueRepository employeRubriqueRepository;










 public double eval(String formule, Map<String, Double> variables) {
     try {
                
                ExpressionBuilder builder = new ExpressionBuilder(formule);
                builder.variables(variables.keySet());
                Expression expression = builder.build();

                for (var entry : variables.entrySet()) {
                    expression.setVariable(entry.getKey(), entry.getValue());
                }

                return expression.evaluate();
            } catch (Exception e) {
                System.err.println("Erreur dans la formule '" + formule + "': " + e.getMessage());
                return 0.0;
            }
        }











}
